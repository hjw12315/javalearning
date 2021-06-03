// Arrays.sort

public static <T> void sort(T[] a, int fromIndex, int toIndex,
                                Comparator<? super T> c) {
        if (c == null) {
            sort(a, fromIndex, toIndex);  // 使用自然排序
        } else {
            rangeCheck(a.length, fromIndex, toIndex);
            if (LegacyMergeSort.userRequested)
                legacyMergeSort(a, fromIndex, toIndex, c);
            else
                // 使用TimSort
                TimSort.sort(a, fromIndex, toIndex, c, null, 0, 0);
        }

// 自然排序
public static void sort(Object[] a, int fromIndex, int toIndex) {
    rangeCheck(a.length, fromIndex, toIndex);
    if (LegacyMergeSort.userRequested)
        legacyMergeSort(a, fromIndex, toIndex);  // 使用的是归并+插入排序
    else
        ComparableTimSort.sort(a, fromIndex, toIndex, null, 0, 0);
}
private static <T> void legacyMergeSort(T[] a, Comparator<? super T> c) {
    T[] aux = a.clone();  // 一维数组深复制
    if (c==null)
        mergeSort(aux, a, 0, a.length, 0);
    else
        mergeSort(aux, a, 0, a.length, 0, c);
}

@SuppressWarnings({"rawtypes", "unchecked"})
private static void mergeSort(Object[] src,
                              Object[] dest,
                              int low, int high, int off,
                              Comparator c) {
    int length = high - low;
    // Insertion sort on smallest arrays
    // 一直到数组长度小于7的时候，开始使用插入排序
    if (length < INSERTIONSORT_THRESHOLD) {  // INSERTIONSORT_THRESHOLD = 7
        for (int i=low; i<high; i++)  // 这里的high是数组长度，没减1
            // 插入排序，后面的数一直和前面的数进行比较，如果后面的小于前面的，就交换两个数
            for (int j=i; j>low && c.compare(dest[j-1], dest[j])>0; j--)
                swap(dest, j, j-1);
        return;
    }

    // Recursively sort halves of dest into src
    int destLow  = low;
    int destHigh = high;
    low  += off;
    high += off;
    int mid = (low + high) >>> 1;  //  
    // 这里把dest和src进行了交换，src是复制品
    mergeSort(dest, src, low, mid, -off, c);  // 归并排序，递归调用 
    mergeSort(dest, src, mid, high, -off, c); 

    // If list is already sorted, just copy from src to dest.  This is an
    // optimization that results in faster sorts for nearly ordered lists.
    // 如果前半部分的最大值小于后半部分的最小值，则直接返回
    if (c.compare(src[mid-1], src[mid]) <= 0) {
       System.arraycopy(src, low, dest, destLow, length);
       return;
    }

    // Merge sorted halves (now in src) into dest
    // 双指针，前半部分一个指针，后半部分一个指针
    for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
        // 注意短路或
        if (q >= high || p < mid && c.compare(src[p], src[q]) <= 0)
            dest[i] = src[p++];
        else
            dest[i] = src[q++];
    }
}

// ComparableTimSort.sort
static void sort(Object[] a, int lo, int hi, Object[] work, int workBase, int workLen) {
    assert a != null && lo >= 0 && lo <= hi && hi <= a.length;

    int nRemaining  = hi - lo;
    if (nRemaining < 2)
        return;  // Arrays of size 0 and 1 are always sorted

    // If array is small, do a "mini-TimSort" with no merges
    // 数组长度小于32
    if (nRemaining < MIN_MERGE) {  // MIN_MERGE = 32
        // 统计上升结束位置
        int initRunLen = countRunAndMakeAscending(a, lo, hi);
        binarySort(a, lo, hi, lo + initRunLen);
        return;
    }

    /**
     * March over the array once, left to right, finding natural runs,
     * extending short natural runs to minRun elements, and merging runs
     * to maintain stack invariant.
     */
    ComparableTimSort ts = new ComparableTimSort(a, work, workBase, workLen);
    int minRun = minRunLength(nRemaining);
    do {
        // Identify next run
        int runLen = countRunAndMakeAscending(a, lo, hi);

        // If run is short, extend to min(minRun, nRemaining)
        if (runLen < minRun) {
            int force = nRemaining <= minRun ? nRemaining : minRun;
            binarySort(a, lo, lo + force, lo + runLen);
            runLen = force;
        }

        // Push run onto pending-run stack, and maybe merge
        ts.pushRun(lo, runLen);
        ts.mergeCollapse();

        // Advance to find next run
        lo += runLen;
        nRemaining -= runLen;
    } while (nRemaining != 0);

    // Merge all remaining runs to complete sort
    assert lo == hi;
    ts.mergeForceCollapse();
    assert ts.stackSize == 1;
}
// TimSort排序把开头的下降序列反转，并返回上升序列开始下降的位置
@SuppressWarnings({"unchecked", "rawtypes"})
private static int countRunAndMakeAscending(Object[] a, int lo, int hi) {
    assert lo < hi;
    int runHi = lo + 1;
    if (runHi == hi)
        return 1;

    // Find end of run, and reverse range if descending
    // 如果开头是下降的
    if (((Comparable) a[runHi++]).compareTo(a[lo]) < 0) { // Descending
        while (runHi < hi && ((Comparable) a[runHi]).compareTo(a[runHi - 1]) < 0)
            runHi++;
        reverseRange(a, lo, runHi); // 反转下降部分
    } else {                              // Ascending
        while (runHi < hi && ((Comparable) a[runHi]).compareTo(a[runHi - 1]) >= 0)
            runHi++;
    }

    return runHi - lo;
}

// 二分插入排序
@SuppressWarnings({"fallthrough", "rawtypes", "unchecked"})
private static void binarySort(Object[] a, int lo, int hi, int start) {
    assert lo <= start && start <= hi;
    if (start == lo)
        start++;
    for ( ; start < hi; start++) {
        Comparable pivot = (Comparable) a[start];

        // Set left (and right) to the index where a[start] (pivot) belongs
        int left = lo;
        int right = start;
        assert left <= right;
        /*
         * Invariants:
         *   pivot >= all in [lo, left).
         *   pivot <  all in [right, start).
         */
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (pivot.compareTo(a[mid]) < 0)
                right = mid;
            else
                left = mid + 1;
        }
        assert left == right;

        /*
         * The invariants still hold: pivot >= all in [lo, left) and
         * pivot < all in [left, start), so pivot belongs at left.  Note
         * that if there are elements equal to pivot, left points to the
         * first slot after them -- that's why this sort is stable.
         * Slide elements over to make room for pivot.
         */
        int n = start - left;  // The number of elements to move
        // Switch is just an optimization for arraycopy in default case
        switch (n) {
            case 2:  a[left + 2] = a[left + 1];
            case 1:  a[left + 1] = a[left];
                     break;
            // 从left开始复制n位到left+1开始的位置，右移n位
            default: System.arraycopy(a, left, a, left + 1, n);
        }
        a[left] = pivot;
    }
}

// TimSort
static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c,
T[] work, int workBase, int workLen) {
    assert c != null && a != null && lo >= 0 && lo <= hi && hi <= a.length;

    int nRemaining  = hi - lo;
    if (nRemaining < 2)
        return;  // Arrays of size 0 and 1 are always sorted

    // If array is small, do a "mini-TimSort" with no merges
    if (nRemaining < MIN_MERGE) {   // MIN_MERGE = 32
        int initRunLen = countRunAndMakeAscending(a, lo, hi, c);
        binarySort(a, lo, hi, lo + initRunLen, c);
        return;
    }

    /**
    * March over the array once, left to right, finding natural runs,
    * extending short natural runs to minRun elements, and merging runs
    * to maintain stack invariant.
    */
    TimSort<T> ts = new TimSort<>(a, c, work, workBase, workLen);
    int minRun = minRunLength(nRemaining);
    do {
        // Identify next run
        int runLen = countRunAndMakeAscending(a, lo, hi, c);

        // If run is short, extend to min(minRun, nRemaining)
        if (runLen < minRun) {
        int force = nRemaining <= minRun ? nRemaining : minRun;
        binarySort(a, lo, lo + force, lo + runLen, c);
        runLen = force;
        }

        // Push run onto pending-run stack, and maybe merge
        ts.pushRun(lo, runLen);
        ts.mergeCollapse();

        // Advance to find next run
        lo += runLen;
        nRemaining -= runLen;
    } while (nRemaining != 0);

    // Merge all remaining runs to complete sort
    assert lo == hi;
    ts.mergeForceCollapse();
    assert ts.stackSize == 1;
}
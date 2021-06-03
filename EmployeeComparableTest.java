import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class EmployeeComparableTest {
    public static void main(String[] args){
        var staff = new EmployeeComparable[3];
        staff[0] = new EmployeeComparable("xiaoming", 12980);
        staff[1] = new EmployeeComparable("xiaohong", 13098);
        staff[2] = new EmployeeComparable("xiaowei", 12010);
        Arrays.sort(staff);
        for(EmployeeComparable e:staff)
            System.out.println(e.getName() + " "+ e.getSalary());

        String[] friends = {"Peter", "Paul", "Mary"};
        //Arrays.sort(friends, new LengthComparator());
        Arrays.sort(friends, (s1, s2) -> s1.length() - s2.length());
        for(String s: friends)
            System.out.println(s);
        
        Date d = new Date();
        System.out.println(d.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);

        Calendar c = Calendar.getInstance();
        System.out.println(c.get(c.YEAR));
        
    }
}

class LengthComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        return s1.length() - s2.length();
    }
}

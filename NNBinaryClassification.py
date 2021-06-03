import torch
import torch.nn as nn
import torch.nn.functional as F
import random
from sklearn import datasets
from sklearn.metrics import roc_auc_score

dataset = datasets.load_iris()
data = dataset['data']
label = dataset['target']

index = label!=2
data = data[index]
label = label[index]

print(data)
print(label)

# input = torch.FloatTensor(data)
# label = torch.LongTensor(label)
input = torch.tensor(data, dtype=torch.float)
label = torch.tensor(label, dtype=torch.long)

class Net(torch.nn.Module):
    def __init__(self, n_feature, n_hidden, n_output):
        super(Net, self).__init__()
        self.hidden = torch.nn.Linear(n_feature, n_hidden)
        self.hidden_2 = torch.nn.Linear(n_hidden, n_hidden)
        self.out = torch.nn.Linear(n_hidden, n_output)

    def forward(self, x):
        hidden_1 = F.relu(self.hidden(x))  
        hidden_2 = F.relu(self.hidden_2(hidden_1)) 
        x = self.out(hidden_2) 
        return torch.sigmoid(x)

# n_output=1 为什么不行
net = Net(n_feature=4, n_hidden=10, n_output=2)
optimizer = torch.optim.SGD(net.parameters(), lr=0.01)
loss = torch.nn.CrossEntropyLoss()

for i in range(500):
    out = net(input)

    optimizer.zero_grad()
    ls = loss(out, label)
    ls.backward()
    optimizer.step()

pred = net(input)
print(pred)
prediction = torch.max(pred, 1)[1]
pred_y = prediction.numpy()
target_y = label.data.numpy()
print(roc_auc_score(target_y, pred_y))
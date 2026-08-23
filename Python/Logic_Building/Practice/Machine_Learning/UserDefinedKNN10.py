import numpy as np
import math

def MarvellousEUCDistance(p1,p2):
    Ans = math.sqrt((p1['X'] - p2['X'])**2 + (p1['Y'] - p2['Y'])**2)
    return Ans

def MarvellousKNNClassifier(k = 3):
    Border = "-"*50
    
    Data = [
        {'point' : 'A', 'X' : 1, 'Y' : 2, 'label' : 'Red'},
        {'point' : 'B', 'X' : 2, 'Y' : 3, 'label' : 'Red'},
        {'point' : 'C', 'X' : 3, 'Y' : 1, 'label' : 'Blue'},
        {'point' : 'D', 'X' : 5, 'Y' : 6, 'label' : 'Blue'},
        {'point' : 'E', 'X' : 6, 'Y' : 6, 'label' : 'Blue'},
        {'point' : 'F', 'X' : 3, 'Y' : 4, 'label' : 'Red'},
        {'point' : 'G', 'X' : 3, 'Y' : 2, 'label' : 'Red'}
    ]
    
    print(Border)
    print("Marvellous KNN Classifier")
    print(Border)
    
    for i in Data:
        print(i)
    
    print(Border)
    
    new_point = {'X' : 3, 'Y' : 3}
    
    print("Distances of all points : ")
    print(Border)
    
    for d in Data:
       d['distance'] = MarvellousEUCDistance(d,new_point)
       
    for d in Data:
        print(d)
       
    print(Border)
    
    sorted_data = sorted(Data, key = lambda item : item['distance'])
    
    print("Sorted Data : ")
    
    for d in sorted_data:
        print(d)
        
    print(Border)
    
    nearest = sorted_data[:k]                # Array Slicing
    
    print(Border)
    print("Nearest 3 members are : ", nearest)
    print(Border)
    
    for d in nearest:
        print(d)
        
    print(Border)
    
    # Voting
    votes = {}
    
    for neighbors in nearest:
        label = neighbors['label']
        votes[label] = votes.get(label, 0) + 1
    
    print(Border)
    print("Voting Result is : ")
    print(Border)
    
    for d in votes:
        print("Name : ", d, "Number  of votes : ", votes[d])
        
    print(Border)
    
    iMax = 0
    Name = ""
    
    for d in votes:
        if(votes[d] > iMax):
            iMax = votes[d]
            Name = d
    
    print("Final Prediction is : ", Name)
    
        
def main():
    MarvellousKNNClassifier(5)


if __name__ == "__main__":
    main()
    
# convert thid code into oop using class method and variable
# pandas add write csv - temprorary.csv banvun read kraycha ae
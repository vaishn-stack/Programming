import numpy as np
import math

def MarvellousEUCDistance(p1,p2):
    Ans = math.sqrt((p1['X'] - p2['X'])**2 + (p1['Y'] - p2['Y'])**2)
    return Ans

def MarvellousKNNClassifier():
    Border = "-"*50
    
    Data = [
        {'point' : 'A', 'X' : 1, 'Y' : 2, 'label' : 'Red'},
        {'point' : 'B', 'X' : 2, 'Y' : 3, 'label' : 'Red'},
        {'point' : 'C', 'X' : 3, 'Y' : 1, 'label' : 'Blue'},
        {'point' : 'D', 'X' : 5, 'Y' : 6, 'label' : 'Blue'}
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
    
        
def main():
    MarvellousKNNClassifier()


if __name__ == "__main__":
    main()
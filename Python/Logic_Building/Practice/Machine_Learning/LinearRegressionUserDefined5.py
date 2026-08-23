import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

def MarvellousPredictor():
    
    # 1.Load the data
    
    X = [1,2,3,4,5]
    Y = [3,4,2,4,5]
    
    print("Values of independent variables X : ", X)
    print("Values of dependent variables Y : ", Y)
    
    sum_x = 0
    sum_y = 0
    
    for i in range(len(X)):
        sum_x = sum_x + X[i]
        sum_y = sum_y + Y[i]
        
    mean_x = sum_x / len(X)   # Xbar
    mean_y = sum_y / len(Y)
        
    print("Mean_X is : ", mean_x)
    print("Mean_Y is : ", mean_y)
    
    n = len(X)          # 5
    
    numerator = 0
    denomerator = 0
    
    # m = sum(X - xbar) * (Y - ybar) / sum(X - xbar) ** 2
    # Calculate slope i.e (m)
    for i in range(n):
        numerator = numerator + ((X[i] - mean_x) * (Y[i] - mean_y)) 
        denomerator = denomerator + ((X[i] - mean_x) ** 2)
        
    m = numerator / denomerator
        
    print("Slope of line i.e m : ", m)

    # y = mx + c
    # c = y - mx
    # c = ymean - m * xmean
    
    c = mean_y - m  * mean_x
    
    print("Y-intercept i.e C : ", c)
        
    
    
        

def main():
    MarvellousPredictor()

if __name__ == "__main__":
    main()
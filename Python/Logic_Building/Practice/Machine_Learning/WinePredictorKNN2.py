import pandas as pd
import matplotlib.pyplot as plt

from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix
from sklearn.preprocessing import StandardScaler

def MarvellousClassifier(DataPath):
    Border = "-"*50
    
    # Step 1 : Load the dataset from csv file
    
    print(Border)
    print("Step 1 : Load the dataset from csv file")
    print(Border)
    
    df = pd.read_csv(DataPath)
    
    print(Border)
    print("Some entries from dataset : ")
    print(df.head())
    print(Border)
    
    # Step 2 : Clean the dataset
    
    print(Border)
    print("Step 2 : Clean the dataset")
    print(Border)
    
    df.dropna(inplace = True)
    
    print("Shape od dataset : ", df.shape)
    print("Total records : ",df.shape[0])
    print("Total Columns : ", df.shape[1])
    
    print(Border)
    
    
def main():
    MarvellousClassifier("WinePredictor.csv")

if __name__ == "__main__":
    main()
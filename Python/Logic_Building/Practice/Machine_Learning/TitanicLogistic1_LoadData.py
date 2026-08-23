import numpy as np
import pandas as pd
import joblib

from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix

# step 1 : Load the data

#----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : Load Data
#   Description :   Load the Data from CSV
#   Input :         Name of CSV file
#   Output :        Data Frame
#   Author :        Vaishnavi Deepak Morankar
#   Date :          16/08/2026
#
#----------------------------------------------------------------------------------------------------------------------------


def LoadData(filename):
    df = pd.read_csv(filename)
    
    print("Dataset loaded Successfully")
    print(df.head())
    


#----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : main
#   Description :   Entry point Function
#   Input :         None
#   Output :        None
#   Author :        Vaishnavi Deepak Morankar
#   Date :          16/08/2026
#
#----------------------------------------------------------------------------------------------------------------------------
def main():
    LoadData("MarvellousTitanicDataset.csv")

if __name__ == "__main__":
    main()
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

    # Step 3 : Separate independent and dependent variables
    
    print(Border)
    print("Step 3 : Separate independent and dependent variables")
    print(Border)
    
    X = df.drop(columns = ['Class'])
    Y = df['Class']
    
    print("Shape of X : ", X.shape)
    print("Shape of Y : ", Y.shape)
    
    print(Border)
    print("Input columns : ", X.columns.tolist())
    print("Output column : Class")
    print(Border)
    
    # Step 4 : Split the dataset for training and testing
    
    print(Border)
    print("Step 4 : Split the dataset for training and testing")
    print(Border)
    
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.2, random_state = 42, stratify = Y)
    
    print(Border)
    print("Details of training and testing data")
    
    print("Shape of X_train : ", X_train.shape)
    print("Shape of X_test : ", X_test.shape)
    
    print("Shape of Y_train : ", Y_train.shape)
    print("Shape of Y_test : ", Y_test.shape)
    
    print(Border)
    
    # Step 5 : Feature Scaling
    
    print(Border)
    print("Step 5 : Feature Scaling")
    print(Border)
    
    scalar = StandardScaler()
    X_train_scaled = scalar.fit_transform(X_train)
    X_test_scaled = scalar.fit_transform(X_test)
    
    print("Feature Scaling Done...")
    
    print(Border)
    
    # Step 6 : Build the model
    
    print(Border)
    print("Step 6 : Build the model")
    print(Border)
    
    model = KNeighborsClassifier(n_neighbors = 9)
    
    print("Classification model is created...")
    
    # Step 7 : Train the model
    
    print(Border)
    print("Step 7 : Train the model")
    print(Border)
    
    model = model.fit(X_train_scaled, Y_train)
    
    print("Model Training Completed...")
    
    print(Border)
    
    # Step 8 : Test the model
        
    print(Border)
    print("Step 8 : Test the model")
    print(Border)
    
    Y_pred = model.predict(X_test_scaled)

    accuracy = accuracy_score(Y_test, Y_pred)
    print("Model accuracy is : ", accuracy * 100)
    
    print(Border)
    
def main():
    MarvellousClassifier("WinePredictor.csv")

if __name__ == "__main__":
    main()
    
# interview - over fitting and under fitting - accuracy check for training and testing
# high bayes, variance
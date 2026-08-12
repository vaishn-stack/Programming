import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report


def WineClassification():
    print("Wine Classification using Machine Learning")
    print("-" * 50)

    # Step 1 : Get Data
    print("\nStep 1 : Get Data")

    df = pd.read_csv("WinePredictor.csv")

    print("Dataset loaded successfully")
    print("Shape of Dataset :", df.shape)

    # Display first 5 records
    print("\nFirst 5 records:")
    print(df.head())

    # Step 2 : Clean, Prepare and Manipulate Data
    print("\nStep 2 : Clean, Prepare and Manipulate Data")

    # Check missing values
    print("\nMissing values:")
    print(df.isnull().sum())

    # Correct first column name
    df.rename(columns={df.columns[0]: "Class"}, inplace=True)

    # Separate features and target
    X = df.drop("Class", axis=1)
    Y = df["Class"]

    print("\nFeatures:")
    print(X.columns)

    print("\nTarget:")
    print(Y.unique())

    # Step 3 : Train Data
    print("\nStep 3 : Train Data")

    X_train, X_test, Y_train, Y_test = train_test_split(
        X,
        Y,
        test_size=0.2,
        random_state=42,
        stratify=Y
    )

    print("Training data :", X_train.shape)
    print("Testing data  :", X_test.shape)

    # Feature Scaling
    scaler = StandardScaler()

    X_train = scaler.fit_transform(X_train)
    X_test = scaler.transform(X_test)

    # Create KNN classifier
    Model = KNeighborsClassifier(n_neighbors=5)

    # Train model
    Model.fit(X_train, Y_train)

    print("Model trained successfully")

    # Step 4 : Test Data
    print("\nStep 4 : Test Data")

    Y_pred = Model.predict(X_test)

    print("Predicted values:")
    print(Y_pred)

    print("\nActual values:")
    print(Y_test.values)

    # Step 5 : Calculate Accuracy
    print("\nStep 5 : Calculate Accuracy")

    Accuracy = accuracy_score(Y_test, Y_pred)

    print("Accuracy :", Accuracy * 100, "%")

    # Confusion Matrix
    print("\nConfusion Matrix:")
    print(confusion_matrix(Y_test, Y_pred))

    # Classification Report
    print("\nClassification Report:")
    print(classification_report(Y_test, Y_pred))


if __name__ == "__main__":
    WineClassification()
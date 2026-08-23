import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import BaggingClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

#--------------------------------------------------------------
# step 1 : Load the dataset
#--------------------------------------------------------------

df = pd.read_csv("breast_cancer.csv")

print("Shape of dataset : ",df.shape)
print("First few records : ")
print(df.head())

#--------------------------------------------------------------
# step 2 : Separate features and lables
#--------------------------------------------------------------

X = df.drop("target", axis = 1)
Y = df["target"]

print("X shape : ", X.shape)
print("Y shape : ", Y.shape)

#--------------------------------------------------------------
# step 3 : Split dataset for training and testing
#--------------------------------------------------------------
X_train, X_test, Y_train, Y_test = train_test_split(
                                                       X,
                                                       Y,
                                                       test_size = 0.2,
                                                       random_state = 42
                                                   )

#--------------------------------------------------------------
# step 4 : Scale the features
#--------------------------------------------------------------

scalar = StandardScaler()

X_train = scalar.fit_transform(X_train)
X_test = scalar.fit_transform(X_test)

#--------------------------------------------------------------
# step 5 : Create the base model
#--------------------------------------------------------------

base_model = DecisionTreeClassifier(
                                      random_state = 42
                                   )


#--------------------------------------------------------------
# step 6 : Create the bagging model
#--------------------------------------------------------------

model = BaggingClassifier(
                            estimator = base_model,
                            n_estimators = 10,
                            random_state = 42
                         )

#--------------------------------------------------------------
# step 7 : Train the model
#--------------------------------------------------------------

model.fit(X_train, Y_train)

#--------------------------------------------------------------
# step 8 : Test the model
#--------------------------------------------------------------

Y_pred = model.predict(X_test)

#--------------------------------------------------------------
# step 9 : Evaluate the model
#--------------------------------------------------------------

print("Accuracy : ", accuracy_score(Y_test, Y_pred))
print("Confusion matrix : ")
print(confusion_matrix(Y_test, Y_pred))


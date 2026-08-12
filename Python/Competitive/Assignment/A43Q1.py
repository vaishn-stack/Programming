import pandas as pd

from sklearn.preprocessing import LabelEncoder
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score


def PlayPredictor():

    print("Play Predictor using K-Nearest Neighbors")
    print("-" * 50)

    # --------------------------------------------------
    # Step 1 : Get Data
    # --------------------------------------------------

    print("\nStep 1 : Get Data")

    df = pd.read_csv("MarvellousInfosystems_PlayPredictor.csv")

    print("Dataset loaded successfully")

    print("\nOriginal Column Names:")
    print(df.columns.tolist())

    print("\nFirst 5 records:")
    print(df.head())

    print("\nShape of Dataset :", df.shape)

    # --------------------------------------------------
    # Step 2 : Clean, Prepare and Manipulate Data
    # --------------------------------------------------

    print("\nStep 2 : Clean, Prepare and Manipulate Data")

    # Remove unnecessary index column
    if "Unnamed: 0" in df.columns:
        df.drop("Unnamed: 0", axis=1, inplace=True)

    # Correct spelling of Wether
    df.rename(columns={"Wether": "Weather"}, inplace=True)

    print("\nUpdated Column Names:")
    print(df.columns.tolist())

    # Check missing values
    print("\nMissing values:")
    print(df.isnull().sum())

    # Create Label Encoders
    WeatherEncoder = LabelEncoder()
    TemperatureEncoder = LabelEncoder()
    PlayEncoder = LabelEncoder()

    # Encode Weather
    df["Weather"] = WeatherEncoder.fit_transform(
        df["Weather"]
    )

    # Encode Temperature
    df["Temperature"] = TemperatureEncoder.fit_transform(
        df["Temperature"]
    )

    # Encode Play
    df["Play"] = PlayEncoder.fit_transform(
        df["Play"]
    )

    print("\nEncoded Dataset:")
    print(df)

    # Separate Features and Target
    X = df[["Weather", "Temperature"]]

    Y = df["Play"]

    print("\nFeatures:")
    print(X)

    print("\nTarget:")
    print(Y)

    # --------------------------------------------------
    # Step 3 : Train Data
    # --------------------------------------------------

    print("\nStep 3 : Train Data")

    # K = 3
    Model = KNeighborsClassifier(n_neighbors=3)

    # Train using complete dataset
    Model.fit(X, Y)

    print("Model trained successfully")

    # --------------------------------------------------
    # Step 4 : Test Data
    # --------------------------------------------------

    print("\nStep 4 : Test Data")

    print("\nEnter new weather information")

    Weather = input(
        "Enter Weather (Sunny/Overcast/Rainy): "
    ).strip().capitalize()

    Temperature = input(
        "Enter Temperature (Hot/Mild/Cool): "
    ).strip().capitalize()

    # Check valid Weather
    if Weather not in WeatherEncoder.classes_:
        print("\nInvalid Weather!")
        print("Please enter:", list(WeatherEncoder.classes_))
        return

    # Check valid Temperature
    if Temperature not in TemperatureEncoder.classes_:
        print("\nInvalid Temperature!")
        print("Please enter:", list(TemperatureEncoder.classes_))
        return

    # Convert input into numerical values
    WeatherValue = WeatherEncoder.transform(
        [Weather]
    )[0]

    TemperatureValue = TemperatureEncoder.transform(
        [Temperature]
    )[0]

    # Create new data point
    NewData = [[
        WeatherValue,
        TemperatureValue
    ]]

    # Predict
    Prediction = Model.predict(NewData)

    # Convert numerical prediction back to Yes/No
    Result = PlayEncoder.inverse_transform(Prediction)

    print("\nPredicted Result:", Result[0])

    # --------------------------------------------------
    # Step 5 : Calculate Accuracy
    # --------------------------------------------------

    print("\nStep 5 : Calculate Accuracy")

    YPred = Model.predict(X)

    Accuracy = accuracy_score(Y, YPred)

    print("Accuracy :", Accuracy * 100, "%")


if __name__ == "__main__":
    PlayPredictor()
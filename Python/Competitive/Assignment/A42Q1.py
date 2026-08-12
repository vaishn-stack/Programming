import math


def CalculateDistance(p1, p2):
    Distance = math.sqrt(
        (p1["X"] - p2["X"]) ** 2 +
        (p1["Y"] - p2["Y"]) ** 2
    )

    return Distance


def KNNClassifier():

    Data = [
        {"Point": "A", "X": 1, "Y": 2, "Label": "Red"},
        {"Point": "B", "X": 2, "Y": 3, "Label": "Red"},
        {"Point": "C", "X": 3, "Y": 1, "Label": "Blue"},
        {"Point": "D", "X": 6, "Y": 5, "Label": "Blue"}
    ]

    print("K-Nearest Neighbors Classification")
    print("-" * 50)

    # Accept new point
    X = float(input("Enter X coordinate: "))
    Y = float(input("Enter Y coordinate: "))

    NewPoint = {
        "X": X,
        "Y": Y
    }

    # Calculate distances
    DistanceList = []

    for point in Data:

        Distance = CalculateDistance(point, NewPoint)

        DistanceList.append({
            "Point": point["Point"],
            "Distance": Distance,
            "Label": point["Label"]
        })

    # Sort distances
    DistanceList.sort(key=lambda x: x["Distance"])

    # K = 3
    K = 3

    NearestNeighbors = DistanceList[:K]

    print("\nNearest Neighbors:")

    for point in NearestNeighbors:
        print(
            point["Point"],
            "- Distance:",
            round(point["Distance"], 2)
        )

    # Majority voting
    Labels = []

    for point in NearestNeighbors:
        Labels.append(point["Label"])

    RedCount = Labels.count("Red")
    BlueCount = Labels.count("Blue")

    if RedCount > BlueCount:
        Prediction = "Red"
    else:
        Prediction = "Blue"

    print("\nPredicted Class:", Prediction)


if __name__ == "__main__":
    KNNClassifier()
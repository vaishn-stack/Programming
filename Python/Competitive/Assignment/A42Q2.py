import math


def CalculateDistance(p1, p2):
    return math.sqrt(
        (p1["X"] - p2["X"]) ** 2 +
        (p1["Y"] - p2["Y"]) ** 2
    )


def PredictClass(Data, NewPoint, K):

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

    # Select K nearest neighbors
    Neighbors = DistanceList[:K]

    # Majority voting
    Labels = []

    for point in Neighbors:
        Labels.append(point["Label"])

    RedCount = Labels.count("Red")
    BlueCount = Labels.count("Blue")

    if RedCount > BlueCount:
        return "Red"
    elif BlueCount > RedCount:
        return "Blue"
    else:
        return "Tie"


def KValueDemo():

    Data = [
        {"Point": "A", "X": 1, "Y": 2, "Label": "Red"},
        {"Point": "B", "X": 2, "Y": 3, "Label": "Red"},
        {"Point": "C", "X": 3, "Y": 1, "Label": "Blue"},
        {"Point": "D", "X": 6, "Y": 5, "Label": "Blue"}
    ]

    NewPoint = {
        "X": 2,
        "Y": 2
    }

    print("Prediction Results")
    print("-" * 30)

    for K in [1, 3, 5]:

        # K cannot be greater than dataset size
        ActualK = min(K, len(Data))

        Prediction = PredictClass(
            Data,
            NewPoint,
            ActualK
        )

        print(
            "K =", K,
            "->",
            Prediction
        )


if __name__ == "__main__":
    KValueDemo()
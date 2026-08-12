import math


def CalculateDistance(p1, p2):

    Distance = math.sqrt(
        (p1["StudyHours"] - p2["StudyHours"]) ** 2 +
        (p1["Attendance"] - p2["Attendance"]) ** 2
    )

    return Distance


def StudentKNN():

    Data = [
        {"StudyHours": 2, "Attendance": 60, "Result": "Fail"},
        {"StudyHours": 5, "Attendance": 80, "Result": "Pass"},
        {"StudyHours": 6, "Attendance": 85, "Result": "Pass"},
        {"StudyHours": 1, "Attendance": 50, "Result": "Fail"}
    ]

    print("Student Result Prediction using KNN")
    print("-" * 50)

    # Accept input
    StudyHours = float(input("Enter Study Hours: "))
    Attendance = float(input("Enter Attendance: "))

    NewStudent = {
        "StudyHours": StudyHours,
        "Attendance": Attendance
    }

    # Calculate distances
    DistanceList = []

    for student in Data:

        Distance = CalculateDistance(
            student,
            NewStudent
        )

        DistanceList.append({
            "StudyHours": student["StudyHours"],
            "Attendance": student["Attendance"],
            "Result": student["Result"],
            "Distance": Distance
        })

    # Sort distances
    DistanceList.sort(
        key=lambda x: x["Distance"]
    )

    # K = 3
    K = 3

    Neighbors = DistanceList[:K]

    print("\nNearest Neighbors:")

    for student in Neighbors:

        print(
            "Study Hours:", student["StudyHours"],
            "Attendance:", student["Attendance"],
            "Distance:", round(student["Distance"], 2),
            "Result:", student["Result"]
        )

    # Majority voting
    Results = []

    for student in Neighbors:
        Results.append(student["Result"])

    PassCount = Results.count("Pass")
    FailCount = Results.count("Fail")

    if PassCount > FailCount:
        Prediction = "Pass"
    else:
        Prediction = "Fail"

    print("\nPredicted Result:", Prediction)


if __name__ == "__main__":
    StudentKNN()
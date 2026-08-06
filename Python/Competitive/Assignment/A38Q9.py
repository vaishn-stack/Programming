import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("student_performance_ml.csv")

plt.scatter(df["AssignmentsCompleted"],
            df["FinalResult"])

plt.title("AssignmentsCompleted vs FinalResult")

plt.xlabel("AssignmentsCompleted")
plt.ylabel("FinalResult")

plt.show()
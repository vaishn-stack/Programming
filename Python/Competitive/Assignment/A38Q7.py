import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("student_performance_ml.csv")

pass_students = df[df["FinalResult"] == 1]
fail_students = df[df["FinalResult"] == 0]

plt.scatter(pass_students["StudyHours"], 
            pass_students["PreviousScore"],
            color = "green",
            label = "Pass"
           )

plt.scatter(fail_students["StudyHours"],
            fail_students["PreviousScore"],
            color="red",
            label="Fail")

plt.title("StudyHours vs PreviousScore")

plt.xlabel("StudyHours")
plt.ylabel("PrevoiusScore")

plt.legend()
plt.show()
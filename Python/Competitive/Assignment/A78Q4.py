import streamlit as st

st.title("Student Result Calculator")

name = st.text_input("Enter Student Name : ")

st.subheader("Enter Subject Marks : ")

subject1 = st.number_input(
    "Subject 1 Marks : ",
    min_value = 0,
    max_value = 100,
    value = 0
)

subject2 = st.number_input(
    "Subject 2 Marks : ",
    min_value  =0,
    max_value = 100,
    value = 0 
)

subject3 = st.number_input(
    "Subject 3 Marks : ",
    min_value = 0,
    max_value = 100,
    value = 0
)

if st.button("Calculate Result"):
    if name.strip() == "":
        st.warning("Please enter the student's name.")
    else:
        total = subject1 + subject2 + subject3
        percentage = total / 3

        st.write(f"Student Name : {name}")
        st.write(f"Total Marks : {total} / 300")
        st.write(f"Percentage : {percentage:.2f}%")

        if (
            subject1 >= 40
            and subject2 >= 40
            and subject3 >= 40
        ):
            st.success("Result : PASS")
        else:
            st.error("Result : FAIL")
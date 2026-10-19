import streamlit as st

st.title("Even or Odd Number")

no = st.number_input(
    "Enter an Integer : ",
    value = 0,
    step = 1
)

if st.button("Check"):
    if int(no) % 2 == 0:
        st.success(f"{int(no)} is an Even Number")
    else:
        st.success(f"{int(no)} is an Odd Number")
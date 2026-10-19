import streamlit as st

st.title("Simple Interest Calculator")

principal = st.number_input(
    "Enter Principal Amount : ",
    min_value = 0.0,
    value = 0.0
)

rate = st.number_input(
    "Enter Rate Of Interest (%) : ",
    min_value = 0.0,
    value = 0.0
)

time = st.number_input(
    "Enter Time Period (Years) : ",
    min_value = 0.0,
    value = 0.0
)

if st.button("Calculate"):
    interest = (principal * rate * time) / 100

    st.success(f"Simple Interest = {interest:.2f}")

    total = principal + interest
    st.info(f"Total Amount = {total:.2f}")
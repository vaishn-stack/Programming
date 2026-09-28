# Program to demonstrate Flattening

# Input 2D Matrix
matrix = [
    [6, 4],
    [8, 6]
]

print("Input Matrix:")

for row in matrix:
    print(row)

# ------------------------------------------------
# Flatten the matrix
# ------------------------------------------------

flatten_output = []

for row in matrix:

    for value in row:

        flatten_output.append(value)


print("\nFlatten Output:")
print(flatten_output)
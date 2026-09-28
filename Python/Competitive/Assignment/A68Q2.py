# Program to demonstrate ReLU and Max Pooling

# Input Feature Map
feature_map = [
    [3, 3, 3],
    [0, 0, 0],
    [-3, -3, -3]
]

# ------------------------------------------------
# Step 1: Apply ReLU
# ------------------------------------------------

relu_output = []

for row in feature_map:

    new_row = []

    for value in row:

        # ReLU rule
        if value < 0:
            new_row.append(0)
        else:
            new_row.append(value)

    relu_output.append(new_row)


print("ReLU Output:")

for row in relu_output:
    print(row)


# ------------------------------------------------
# Step 2: 2x2 Max Pooling
# ------------------------------------------------

pool_size = 2

pool_rows = len(relu_output) - pool_size + 1
pool_cols = len(relu_output[0]) - pool_size + 1

pool_output = []

for i in range(pool_rows):

    row = []

    for j in range(pool_cols):

        # Get 2x2 region
        region = []

        for pi in range(pool_size):

            for pj in range(pool_size):

                region.append(
                    relu_output[i + pi][j + pj]
                )

        # Find maximum value
        maximum = max(region)

        row.append(maximum)

    pool_output.append(row)


print("\nMax Pooling Output:")

for row in pool_output:
    print(row)
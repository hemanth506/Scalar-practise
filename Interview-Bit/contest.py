def main():
    N,M,Q = list(map(int, input().split()))
    
    matrix = [[0 for i in range(M)] for i in range (N)]
    # print(matrix)
    integer = 1
    for i in range(N):
        for j in range(M):
            matrix[i][j] = integer
            integer += 1
            print(i,j,matrix)

    print(matrix)
    for i in range(Q):
        inputs = list(map(int, input().split()))
        
        if inputs[0] == 1:
            c1 = inputs[1] - 1
            c2 = inputs[2] - 1
            
            for k in range(N):
                temp = matrix[k][c1]
                matrix[k][c1] = matrix[k][c2]
                matrix[k][c2] = temp

            print(matrix)
        elif inputs[0] == 2:
            r1 = inputs[1] - 1
            r2 = inputs[2] - 1
            
            for k in range(M):
                temp = matrix[r1][k]
                matrix[r1][k] = matrix[r2][k]
                matrix[r2][k] = temp
                
            print(matrix)
            
        elif inputs[0] == 3:
            X1 = inputs[1] - 1
            Y1 = inputs[2] - 1
            X2 = inputs[3] - 1
            Y2 = inputs[4] - 1
            
            int1 = matrix[X1][Y1]
            int2 = matrix[X2][Y2]
            
            print(int1 | int2)
            print(matrix)
            
        else:
            X1 = inputs[1] - 1
            Y1 = inputs[2] - 1
            X2 = inputs[3] - 1
            Y2 = inputs[4] - 1
            
            int1 = matrix[X1][Y1]
            int2 = matrix[X2][Y2]
            
            print(int1 & int2)
            print(matrix)


    return 0

main()
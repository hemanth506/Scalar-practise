# incorrect
def alternatingCharacters(s):
    checkChar = ['A', 'B']
    j = 0
    appendList = []
    for i in range(len(s)):
        
        print(i, j, s[i], checkChar[j])
        if s[i] != checkChar[j]:
            appendList.append(i)
            j -= 1
        j += 1
        if j == 2:
            j = 0
    return len(appendList)

# correct
def alternatingCharactersAnother(s):
    previousState = s[0]
    ct = 0
    for i in range(1, len(s)):
        print(previousState, s[i])
        if previousState == s[i]:
            ct += 1
        else:
            previousState = s[i]

    return ct

s = 'AABABB'
# s = 'BABABA'
# print(alternatingCharacters(s))
print(alternatingCharactersAnother(s))
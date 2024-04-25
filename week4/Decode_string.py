class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        
        for char in s:
            if char != ']':
                # Push everything except the closing bracket onto the stack
                stack.append(char)
            else:
                # If you find a closing bracket, start decoding
                encoded_string = ''
                while stack and stack[-1] != '[':
                    encoded_string = stack.pop() + encoded_string
                
                # Pop the '['
                stack.pop()
                
                # Determine the number k
                k = ''
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                k = int(k)
                
                # Repeat the decoded string k times and push back onto the stack
                stack.append(encoded_string * k)
                
        # Join everything left in the stack to get the final decoded string
        return ''.join(stack)

        
        
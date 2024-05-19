int doubler(int x)
begin
   if(true) then
   begin
    return x + x;
   end
   return x;
end

int multiply(String a, int b)
begin
    int result;
    result = a * b;
    return result;
end

void main()
begin
    print doubler("2");
    print multiply("3", 4);
end

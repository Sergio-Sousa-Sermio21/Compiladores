int double(int x)
begin
   if(true) then
   begin
    return x + x;
   end
   return x;
end

int multiply(int a, int b)
begin
    int result;
    result = a * b;
    return result;
end

void main()
begin
    print double(2);
    print multiply(3, 4);
end

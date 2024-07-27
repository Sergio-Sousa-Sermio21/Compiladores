int doubler(int x)
begin
  while x < 2*x do
   begin
        if x < 0 then
            x = x - 1;
        else
        begin
            x = x + 1;
        end
   end
   return x;
end

void main()
begin
     print doubler(2);
end


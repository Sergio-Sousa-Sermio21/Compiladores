int doubler(int x)
begin
   for i = 0 to 2*x do
   begin
        if x < 0 then
            x = x - 1;
            return x;
        else
        begin
            x = x + 1;
        end
   end
end

void main()
begin
     print doubler(2);
end


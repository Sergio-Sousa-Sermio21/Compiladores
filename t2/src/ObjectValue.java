public class ObjectValue {
    private Integer i;
    private Double d;
    private String s;

    private Boolean b;
    ObjectValue(Integer integer) {
        i = integer;
    }
    ObjectValue(Double doubler) {
        d = doubler;
    }
    ObjectValue(String string) {
        s = string;
    }

    ObjectValue(Boolean bool){
        b = bool;
    }

    /**
     * Get the Integer value at the specified index.
     * @param index the index in the stack
     * @return the Integer value
     * @throws IllegalArgumentException if there is no Integer value at the specified index
     */
    public Integer getInt(int index) {
        if (i==null)
            throw new IllegalArgumentException("There is no integer value on current stack position. Line: "+index);
        return i;
    }

    /**
     * Get the Double value at the specified index.
     * @param index the index in the stack
     * @return the Double value
     * @throws IllegalArgumentException if there is no Double value at the specified index
     */
    public Double getDouble(int index) {
        if (d==null)
            throw new IllegalArgumentException("There is no double value on current stack position."+index);
        return d;
    }

    /**
     * Get the String value at the specified index.
     * @param index the index in the stack
     * @return the String value
     * @throws IllegalArgumentException if there is no String value at the specified index
     */
    public String getString(int index) {
        if (s==null)
            throw new IllegalArgumentException("There is no string on current stack position."+index);
        return s;
    }

    /**
     * Get the Boolean value at the specified index.
     * @param index the index in the stack
     * @return the Boolean value
     * @throws IllegalArgumentException if there is no Boolean value at the specified index
     */
    public Boolean getBool(int index) {
        if (b==null)
            throw new IllegalArgumentException("There is no boolean value on current stack position."+index);
        return b;
    }

    @Override
    public String toString() {
        if (i != null) {
            return i.toString();
        }else if (d != null) {
            return d.toString();
        } else if (s !=null) {
            return s;
        }
        return b.toString();
    }
}

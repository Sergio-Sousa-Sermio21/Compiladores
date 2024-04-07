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
     *
     * @param index
     * @return
     */
    public Integer getInt(int index) {
        if (i==null)
            throw new IllegalArgumentException("There is no integer value on current stack position. Line: "+index);
        return i;
    }

    /**
     *
     * @param index
     * @return
     */
    public Double getDouble(int index) {
        if (d==null)
            throw new IllegalArgumentException("There is no double value on current stack position."+index);
        return d;
    }

    /**
     *
     * @param index
     * @return
     */
    public String getString(int index) {
        if (s==null)
            throw new IllegalArgumentException("There is no string on current stack position."+index);
        return s;
    }

    /**
     *
     * @param index
     * @return
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

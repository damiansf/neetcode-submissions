class MinStack {

    private int[] values; // Stack
    private int[] mins;   // To track minimum at each level
    private int size;

    public MinStack() {
        this.values = new int[4];
        this.mins = new int[4];
        this.size = 0;
    }
    
    public void push(int val) {
        if(size == values.length) {
            resize();
        }

        values[size] = val;

        if(size == 0) {
            mins[size] = val;
        } else {
            mins[size] = Math.min(val, mins[size - 1]);
        }

        size++;
    }
    
    public void pop() {

        size--;
    }
    
    public int top() {
        return values[size-1];
    }
    
    public int getMin() {
        return mins[size - 1];
    }

    private void resize() {
        int newCapacity = values.length*2;

        int[] newValues = new int[newCapacity];
        int[] newMins = new int[newCapacity];

        for(int i = 0; i < size; i++) {
            newValues[i] = values[i];
            newMins[i] = mins[i];
        }
        values = newValues;
        mins = newMins;
    }
}

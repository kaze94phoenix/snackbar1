/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celso;

/**
 *
 * @author OsvaldoMaria
 */
class State_2 {
    /*
     * Amount in jug1 for current State
     */

    int x;
    /*
     * Amount in jug2 for current State
     */
    int y;

    /*
     * Parent of current State
     */
    State_2 pre;

    public State_2(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public State_2(int x, int y, State_2 pre) {
        super();
        this.x = x;
        this.y = y;
        this.pre = pre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        State_2 other = (State_2) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (pre != null) {
            builder.append(pre);
        }
        builder.append(x);
        builder.append("    ").append(y).append("\n");
        return builder.toString();
    }
}

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
import java.util.HashSet;
import java.util.LinkedList;

public class Test {

    HashSet<State_2> uniqueStates;

    void letsRoll() {
        /*
         * The capacity of jug1(jug1 capacity is greater than jug2 capacity)
         */
        int jug1 = 4;

        /*
         * The capacity of jug two
         */
        int jug2 = 3;

        /*
         * Final Amount needed in jug1
         */
        int amtNeeded = 2;

        State_2 initialState = new State_2(0, 0);
        State_2 finalState = new State_2(amtNeeded, 0);
        State_2 finalPath = null;

        uniqueStates = new HashSet<>();

        /*
         * Change queue to stack to convert to DFS
         */
        LinkedList<State_2> queue = new LinkedList<>();
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State_2 currState = queue.poll();
            if (currState.equals(finalState)) {
                finalPath = currState;
                break;
            }

            // if x is zero fill it
            if (currState.x == 0) {
                State_2 nextState = new State_2(jug1, currState.y, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if y is empty fill it
            if (currState.y == 0) {
                State_2 nextState = new State_2(currState.x, jug2, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if x is not empty , empty it
            if (currState.x > 0) {
                State_2 nextState = new State_2(0, currState.y, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if y is not empty, empty it
            if (currState.y > 0) {
                State_2 nextState = new State_2(currState.x, 0, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // transfer from x to y, when x non empty and y is not full
            if (currState.x > 0 && currState.y < jug2) {
                int amtToTransfer = Math.min(currState.x, jug2 - currState.y);
                State_2 nextState = new State_2(currState.x - amtToTransfer, currState.y
                        + amtToTransfer,
                        currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // transfer from y to x, when y is not empty and x is not full
            if (currState.y > 0 && currState.x < jug1) {
                int amtToTransfer = Math.min(currState.y, jug1 - currState.x);
                State_2 nextState = new State_2(currState.x + amtToTransfer, currState.y
                        - amtToTransfer,
                        currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }
        }
        if (finalPath != null) {
            System.out.println("J1  J2");
            System.out.println(finalPath);
        } else {
            System.out.println("Not Possible");

        }
    }

    /*
     * Checks whether State toCheck has been generated before, if not it is
     * added to queue and uniqueStates Set
     */
    void checkUniqueStates(HashSet<State_2> uniqueStates, State_2 toCheck,
            LinkedList<State_2> queue) {
        if (!uniqueStates.contains(toCheck)) {
            uniqueStates.add(toCheck);
            queue.add(toCheck);
        }
    }

    public static void main(String[] args) {
        new Test().letsRoll();
    }
}

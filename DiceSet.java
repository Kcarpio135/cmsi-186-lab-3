import java.util.*;

public class DiceSet {

    private Die[] dice;

    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        if (numberOfDice < 2) {
          throw new IllegalArgumentException("At least two dice required");
        }
        if (sidesOnEachDie < 4) {
          throw new IllegalArgumentException("Dice must have at least four sides");
        }

        this.dice = new Die[numberOfDice];
        for(int i = 0; i < numberOfDice; i++) {
            this.dice[i] = new Die(sidesOnEachDie,1);
        }
    }

    public DiceSet(int sidesOnEachDie, int... values) {
      if (values.length < 2) {
        throw new IllegalArgumentException("At least two dice required");
      }
      if (sidesOnEachDie < 4) {
        throw new IllegalArgumentException("Dice must have at least four sides");
      }

      this.dice = new Die[values.length];
      for(int i = 0; i < values.length; i++){
          this.dice[i] = new Die(sidesOnEachDie,values[i]);
      }
    }

    public String descriptor() {
        return this.dice.length + "d" + this.dice[0].getSides() ;
    }

    public int sum() {
        int sum = 0;
        for(int i = 0; i < this.dice.length; i++){
            sum += this.dice[i].getValue();
        }
        return sum;
    }

    public void rollAll() {
      for(int i = 0; i < this.dice.length; i++){
          this.dice[i].roll();
      }
    }

    public void rollIndividual(int i) {
      this.dice[i].roll();
    }

    public int getIndividual(int i) {
        return this.dice[i].getValue();
    }

    public List<Integer> values() {
      var result = new ArrayList<Integer>();
      for (var d: this.dice){
          result.add(d.getValue());
      }
      return result;
    }

    public boolean isIdenticalTo(DiceSet diceSet) {
      return true;
    }

    @Override public String toString() {
      var result = "";
      for (var d: this.dice){
          result += "[" + d.getValue() + "]";
      }
        return result;
    }
}

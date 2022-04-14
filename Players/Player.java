package ActionGame.Players;

public interface Player {

    String attack(Player player);

    String getName();

    void takeDamage(int points);

    boolean isAlive();
}

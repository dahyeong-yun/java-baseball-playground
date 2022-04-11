package study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Ball;
import baseball.Game;

class GameTest {

    Game game = Game.start();
		
    @Test
    @DisplayName("게임은 세개의 공을 갖는다")
    void setGame() {
        assertEquals(3, game.getBalls().size());
    }
    
    @Test
    @DisplayName("게임은 중복된 공의 값을 갖지 않는다")
    void isDuplicate() {
    	List<Ball> gameBalls = game.getBalls();
    	List<Integer> valueList = gameBalls.stream().map(ball -> ball.getValue()).collect(Collectors.toList());
    	Set<Integer> resultSet = Sets.newHashSet(valueList);
    	
    	assertEquals(gameBalls.size(), resultSet.size()); 
    }
}

package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Pan implements StepListener {
    GameView view;
    Character character;

    //Camera follows the player
    public Pan(GameView view, Character character){
        this.view = view;
        this.character = character;

    }

    //Zoom out a bit
    @Override
    public void preStep(StepEvent stepEvent) {
        view.setCentre(new Vec2(character.getPosition()));
        view.setZoom(10f);

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}

package faangschool.lambda_and_FI.hogwarts;

import java.util.function.Consumer;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.castSpell(spell));
    }
}

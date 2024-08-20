package faangschool.lambda_and_FI.hogwarts;

import java.util.function.Consumer;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.spellCast(spell);
        System.out.println(result);
    }
}

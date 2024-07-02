package name.huakaipo.sound;

import name.huakaipo.HuakaiPo;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent TIKI_MAN_DEATH_SFX = registerSoundEvent("tiki_man_death_sfx");
    public static final SoundEvent TIKI_MAN_AMBIENT_SFX = registerSoundEvent("tiki_man_ambient_sfx");

    private static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = Identifier.of("huakaipo", name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        HuakaiPo.LOGGER.info("Registering ModSounds for " + HuakaiPo.MOD_ID);
    }
}

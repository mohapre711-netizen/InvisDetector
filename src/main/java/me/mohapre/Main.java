package me.mohapre;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.player.PlayerEntity;

public class Main implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null) {
                for (PlayerEntity player : client.world.getPlayers()) {
                    if (player == client.player) continue;

                    // إذا كان اللاعب مختفياً، نظهره ونفعل التوهج حوله
                    if (player.isInvisible()) {
                        player.setInvisible(false);
                        player.setGlowing(true);
                    }
                }
            }
        });
    }
}


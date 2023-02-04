package com.ben.wandwars.spells.wandEffects;

import com.ben.wandwars.Main;
import com.ben.wandwars.helpers.particles.MovingParticleGroup;
import com.ben.wandwars.spells.components.ProjectileInf;
import com.ben.wandwars.spells.components.ProjectileSpellComponent;
import com.ben.wandwars.spells.components.ProjectileSpellRun;
import com.ben.wandwars.spells.components.blockHit.BlockHitEffect;
import com.ben.wandwars.spells.components.entityDamage.OnHitEffect;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.UUID;

public class BlockHitEffectEveryTickProjectile extends WandEffect{
    public BlockHitEffectEveryTickProjectile(OnHitEffect onHitEffect, BlockHitEffect blockHitEffect, ProjectileInf projectileInf, MovingParticleGroup movingParticleGroup) {
        super(onHitEffect, blockHitEffect, projectileInf, movingParticleGroup);
    }

    @Override
    public void cast(Vector direction, Location location, UUID casterUUID) {
        ProjectileSpellComponent projectileSpellComponent =
                new ProjectileSpellComponent(onHitEffect, blockHitEffect, movingParticleGroup, location, direction, projectileInf, casterUUID);

        projectileSpellComponent.cast(new ProjectileSpellRun() {
            @Override
            public void run() {
                blockHitEffect.hit(location, Main.getInstance(), casterUUID);
            }
        });
    }
}

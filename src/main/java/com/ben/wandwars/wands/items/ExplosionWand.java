package com.ben.wandwars.wands.items;

import com.ben.wandwars.helpers.itemStackHelping.ItemStackHelper;
import com.ben.wandwars.util.spell.SpellCaster;
import com.ben.wandwars.wands.AbilityInf;
import com.ben.wandwars.wands.Wand;
import com.ben.wandwars.wands.items.sniperWand.SniperWandPistolShot;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
(Idea of this is to be a snipe build with some mobility and team play. Pistols are also a good poke/dmg option which should hopefully make the build more fast paced)
Explosion wand:
(poke based attack, good for more neutral moments)
left click:
pistol shot: slight homing, low cooldown, shoot twice in a shot, fast bullet speed, low mana

(pretty self explanotary move. can work well with team play. I'm gonna try to have a fun synergy with pistol, having a good balance of mid dmg/long poke and long/mid damage)
right click:
Snipe: medum cooldown, high damage, basically current right click but shorter delay and lower area, medium mana

(this is mainly meant for teamplay, but it can also play well in 1v1's. This might be a bit op, but I also think it'll make some interactions more fun. This shouldn't be to op for 1v1's since the wand is mainly gonna be focusing on targetting this player
shift left click:
Mark: shoots an invisible raycast, now damage, gives an effect that gives a damage multiple on the hit player, super high mana, super mana

(This is mainly meant for duels where the player can avoid a bit of damage with some skill, also needs the opponent to bait out the shield to win some interactions, which might make some matchups more fun)
shift right click:
parry: small shield, low projectile time, doesn't stop all projctiles stronger ones don't get stopped, medium delay, low mana

(just a tool to keep the opponents away, probably isn't gonna give to much blindness so probably gonna be an escape tool. Also the low proj speed makes it more easiyl escapable)
drop key:
smokebomb: high cooldown, very low range, high mana

(slightly good for mobility, mostly gonna be for getting to high places
offhand:
double jump: high jump, very high cooldown, can be stacked, medium mana

(Idea is a high damage, melee, disruptor build, can also pull enemies into worse positions)
Dark Wand:
left click:
slash: low mana, high damage, short range slash attack, low mana

right click:
bolt: short delay(doesn't stop aiming), high speed, does blind and slow on hit, homing, medium mana, medium cooldown

(is probably gonna need balacing for team play, idea is to seriously punish careless sniper builds. might be comboed with )
shift left click:
telegraphic pull: pulls enemies towards the caster. mid range.

(very similar to snipe wand, but can punish more. Which fits the punish-based wand)
shift right click:
deflects: small shield, low projectile time, doesn't stop all projctiles stronger ones don't get stopped but can stop stronger ones then snipe wand, medium delay, low mana, is a slash, deflects projectiles

drop key:
grand slam:
air:
(not a really good ambush option since the high kb, I imagine it mainly be used as a mixup. could also be good to kb them to a wall with a melee followup)
jumps down into the ground, does more damage and kb the higher jumped from. Also can afflict slowness and blindness depending on how high it starts from
(is a good escape, I imagine this move could be dodged by a skillfull player)
ground: jumps up then does a small slam, high kb

offhand:
Dash: just an extra dash, medium mana, medium cooldown

Mellee wand, mostly focus on area denial, but can do some healing, especially ult can heal a lot.
Light Wand
Left click:
Slash: low kb, low mana, medium damage, low cooldown, does high damage but high kb for mellee

Right click:
Bludgeon: after a short delay, do a more powerful slash(more kb, more damage)

shift left click:
Large shield: Summons a large, moving forward shield, that blocks most attacks. high mana, high cooldown, and pushes enemies away

shift right click:
parry: same as sniper wnad, low mana, medium cooldown

offhand key:
Javelin throw: After a short delay, throw a javelin that summons lightning on hit. Does high damage.

drop key:
team buff: gives a buff to the surrounding team in a circular area, includes speed, resistance, and regen.

Ult: Heal ray: shoot a continous heal ray that heals for a lot of health

glave shot:

Left click:
Glave: needs one glave, basic mellee attack

Right click:
Glave shot: after a short delay, shoot a glaive, consumes 1 glaive.

Shift Left click:


Shift right click:
Glaive block: shoots forward a wide blocking area, block power is based on glaives if 0 move doesn't happen, if 1 move blocks, if 2 move deflects

Offhand:
Teleports to the nearest glave, max range of 30.

Drop:
Moves the nearest glave back towards the player. Stops on walls

Ult

Null Mage
Skills:
Midrange attack
punch
single projectile removal
Multi projectile removal
teleport
ground punch

Left click:
Void blast: Mid range attack that does decent damage

Right click:
Null Fist: Fist that after a delay does high kb and high damage

Shift Left Click:
Ground punch: After a short delay punches up on the block that was looked at when the spell was cast(range limit)

Shift right click: Deletes a projectile the caster was looking at(Needs to be slightly weak)

Offhand:
Teleport

Drop:
Destroys all weak projectiles around the user

Ult:
Null Void: Creates a location where all the projectiles get deleted that weren't the caster's

 */

public class ExplosionWand extends Wand {
    @Override
    public ItemStack getItem() {
        return ItemStackHelper.createItemStack("Test Explosion Wand", Material.STICK);
    }

    @Override
    public void leftClickCast(Player caster) {
        caster.sendMessage("left click cast");
        SniperWandPistolShot sniperWandPistolShot = new SniperWandPistolShot();

        SpellCaster spellCaster = new SpellCaster(caster.getUniqueId());

        sniperWandPistolShot.cast(caster.getEyeLocation(), caster.getLocation().getDirection(), spellCaster);
    }

    @Override
    public void rightClickCast(Player caster) {
        caster.sendMessage("right click cast");
    }

    @Override
    public void offHandCast(Player caster) {
        caster.sendMessage("offhand cast");
    }

    @Override
    public void shiftLeftClickCast(Player caster) {
        caster.sendMessage("Shift left click cast");
    }

    @Override
    public void shiftRightClickCast(Player caster) {
        caster.sendMessage("Shift right click cast");
    }

    @Override
    public void dropKeyCast(Player caster) {
        caster.sendMessage("drop key cast");
    }

    @Override
    public AbilityInf getLeftClickCastInf(Player caster) {
        return new AbilityInf(10);
    }

    @Override
    public AbilityInf getRightClickCastInf(Player caster) {
        return new AbilityInf(10);
    }

    @Override
    public AbilityInf getOffHandCastInf(Player caster) {
        return new AbilityInf(10);
    }

    @Override
    public AbilityInf getShiftLeftClickCastInf(Player caster) {
        return new AbilityInf(10);
    }

    @Override
    public AbilityInf getShiftRightClickCastInf(Player caster) {
        return new AbilityInf(10);
    }

    @Override
    public AbilityInf getDropKeyCast(Player caster) {
        return new AbilityInf(10);
    }
}

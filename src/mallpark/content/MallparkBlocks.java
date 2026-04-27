package mallpark.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.*;

import static mallpark.Mallpark.*;

public class MallparkBlocks{
	public static Block
	
	// drills
	compactDrill,
	
	
	// turrets
	revolution,
	
	// walls
	copperWallHuge, copperWallGigantic, titaniumWallHuge, titaniumWallGigantic;
	
	
	
	public static void load() {
		// region DRILLS
		compactDrill = new Drill("compact-drill"){{
			requirements(Category.production, with(Items.copper, 3));
			tier = 1;
			drillTime = 600;
			size = 1;
			itemCapacity = 3;
			envDisabled = Env.space;
			consumeLiquid(Liquids.water, 0.02f).boost();
		}};
		// endregion
		
		// region TURRETS
		revolution = new ItemTurret("revolution"){{
			requirements(Category.turret, with(Items.copper, 200, Items.titanium, 150, Items.plastanium, 100));
			size = 3;
			scaledHealth = 160;
			coolantMultiplier = 6f;
			liquidCapacity = 25f;
			range = 240f;
			inaccuracy = 3f;
			reload = 4f;
			shoot = new ShootBarrel(){{
				barrels = new float[]{
					0f,1f,0f,
					3f,0f,0f,
					-3f,0f,0f,
				};
			}};
			shootY = 11f;
			shootSound = Sounds.shootSalvo; // temporary ig
			drawer = new DrawTurret(){{
				for(int i = 3; i > 0; i--){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + i){{
						mirror = false;
                        progress = PartProgress.recoil;
                        recoilIndex = f - 1;
                        under = true;
                        moveY = -1f;
                    }});
				}
			}};
			maxAmmo = 40;
			recoils = 3;
			recoil = 0.8f;
			rotateSpeed = 2.25f;
			coolant = consumeCoolant(0.5f);
			ammo(
				Items.copper, new BasicBulletType(6f,2){{
					width = 4f;
					height = 9f;
					shootEffect = Fx.shootSmall;
					lifetime = 40f;
					ammoMultiplier = 6f;
					backColor = Pal.copperAmmoBack;
					frontColor = Pal.copperAmmoFront;
				}},
				Items.plastanium, new BasicBulletType(6f,8){{
					width = 6f;
					height = 6f;
					fragBullets = 8;
					fragBullet = new BasicBulletType(2.5f,3){{
						width = 10f;
						height = 12f;
						shrinkY = 1f;
						lifetime = 15f;
						backColor = Pal.plastaniumBack;
						frontColor = Pal.plastaniumFront;
						despawnEffect = Fx.none;
					}};
					lifetime = 40f;
					shootEffect = Fx.shootBig;
					ammoMultiplier = 4f;
					splashDamage = 40f;
					hitEffect = Fx.plasticExplosion;
					splashDamageRadius = 24f;
					backColor = Pal.plastaniumBack;
					frontColor = Pal.plastaniumFront;
				}},
				Items.metaglass, new BasicBulletType(6f,6){{
					width = 5f;
					height = 8f;
					fragBullets = 4;
					fragBullet = new BasicBulletType(3f,2){{
						width = 5f;
						height = 12f;
						shrinkY = 1f;
						lifetime = 20f;
						backColor = Pal.glassAmmoBack;
						frontColor = Pal.glassAmmoFront;
						despawnEffect = Fx.none;
					}};
					lifetime = 40f;
					shootEffect = Fx.shootSmall;
					reloadMultiplier = 0.8f;
					ammoMultiplier = 3f;
					splashDamage = 40f;
					splashDamageRadius = 24f;
					backColor = Pal.glassAmmoBack;
					frontColor = Pal.glassAmmoFront;
				}},
				Items.graphite, new BasicBulletType(6f,6){{
					width = 6f;
					height = 8f;
					shootEffect = Fx.shootSmall;
					lifetime = 40f;
					ammoMultiplier = 4f;
					splashDamage = 20f;
					splashDamageRadius = 8f;
					backColor = Pal.graphiteAmmoBack;
					frontColor = Pal.graphiteAmmoFront;
				}},
				Items.surgeAlloy, new BasicBulletType(6f,13){{
					width = 6f;
					height = 6f;
					lifetime = 40f;
					shootEffect = Fx.shootBig;
					ammoMultiplier = 5f;
					lightning = 2;
					lightningLength = 5;
					lightningLengthRand = 2;
					reloadMultiplier = 0.9f;
					splashDamage = 75f;
					splashDamageRadius = 38f;
					status = StatusEffects.shocked;
					statusDuration = 10f;
					backColor = Pal.surgeAmmoBack;
					frontColor = Pal.surgeAmmoFront;
				}},
				Items.blastCompound, new BasicBulletType(6f,8){{
					width = 6f;
					height = 6f;
					lifetime = 40f;
					shootEffect = Fx.shootBig;
					reloadMultiplier = 0.75f;
					ammoMultiplier = 4f;
					splashDamage = 40f;
					splashDamageRadius = 75f;
					status = StatusEffects.blasted;
					statusDuration = 60f;
					backColor = Pal.blastAmmoBack;
					frontColor = Pal.blastAmmoFront;
				}}	
			);
		}};
		// endregion
		
		// region WALLS
		copperWallHuge = new Wall("copper-wall-huge"){{
			requirements(Category.defense, ItemStack.mult(copperWall.requirements, 9));
			health = 320 * 9;
			size = 3;
		}};
		copperWallGigantic = new Wall("copper-wall-gigantic"){{
			requirements(Category.defense, ItemStack.mult(copperWall.requirements, 16));
			health = 320 * 16;
			size = 4;
		}};
		
		titaniumWallHuge = new Wall("titanium-wall-huge"){{
			requirements(Category.defense, ItemStack.mult(titaniumWall.requirements, 9));
			health = 440 * 9;
			size = 3;
		}};
		titaniumWallGigantic = new Wall("titanium-wall-gigantic"){{
			requirements(Category.defense, ItemStack.mult(titaniumWall.requirements, 16));
			health = 440 * 16;
			size = 4;
		}};
		// endregion
	}
}
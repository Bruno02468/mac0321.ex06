package rs.oisumida.mac0321.ex06;

import java.util.Random;

import rs.oisumida.mac0321.ex06.factories.PokemonFactory;

public class Map {
	private int w, h;
	private TileType tiles[][];
	private Random rand;
	private int player_x, player_y;
	private String player_emoji;
	
	public Map(Trainer player) {
		this.rand = new Random();
		this.w = 16;
		this.h = 8;
		this.player_x = this.w/2;
		this.player_y = this.h/2;
		this.player_emoji = player.getGender().getEmoji();
		// "Zero fill" map
		this.tiles = new TileType[this.h][this.w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				this.tiles[i][j] = TileType.Grass;
			}
		}
		// Make concrete path
		this.makePath(this.h/2, this.w/2, 32);
	}

	private int randInt(int min, int max) {
		int val = this.rand.nextInt();
		if (val < min) {
			return min;
		}
		if (val > max) {
			return max;
		}
		return val;
	}
	
	private void makePath(int i, int j, int c) {
		if (c <= 0) {
			return;
		}
		this.tiles[i][j] = TileType.Concrete;
		
		if (i == 0 || i == this.h-1 || j == 0 || j == this.w-1) {
			i = randInt(1, this.h-2);
			j = randInt(1, this.w-2);
		}
		
		int i2, j2;
		for (int count = 0; count < 100; count++) {
			try {
				int dir = randInt(0, 3);
				int delta_i[] = {1, -1, 0, 0};
				int delta_j[] = {0, 0, 1, -1};
				
				i2 = i + delta_i[dir];
				j2 = j + delta_j[dir];
				if (this.tiles[i2][j2] != TileType.Concrete) {
					this.tiles[i2][j2] = TileType.Concrete;
					this.makePath(i2, j2, c-1);
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public String toString() {
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (j == this.player_x && i == this.player_y) {
					ans.append(this.player_emoji);
				} else {
					ans.append(this.tiles[i][j]);
				}
			}
			ans.append("\n");
		}
		return ans.toString();
	}
	
	public Trainer movePlayer(Direction dir) throws Exception {
		int x2 = this.player_x + dir.getDeltaX();
		int y2 = this.player_y + dir.getDeltaY();
		if (x2 < 0 || x2 >= this.w || y2 < 0 || y2 >= this.h) {
			throw new Exception("você não pdoe ir para fora do mapa");
		}
		this.player_x = x2;
		this.player_y = y2;
		
		if (this.getPlayerTile() == TileType.Grass && this.rand.nextFloat() < 0.25) {
			Trainer wild = new Trainer("Wild", Gender.NONBINARY);
			wild.givePokemon(PokemonFactory.aleatorio());
			wild.setAutoPlay(true);
			return wild;
		}
		
		return null;
	}

	private TileType getPlayerTile() {
		return this.tiles[this.player_y][this.player_x]; 
	}
}

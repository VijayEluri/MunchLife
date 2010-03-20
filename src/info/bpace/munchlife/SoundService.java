/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.bpace.munchlife;

import android.app.Service;
import android.os.IBinder;
import android.content.Intent;
import android.media.MediaPlayer;

import android.util.Log;

public class SoundService extends Service
{
	MediaPlayer mp = new MediaPlayer();
	
	@Override
	public IBinder onBind(Intent i)
	{
		return mBinder;
	}
	
	private final SSInterface.Stub mBinder = new SSInterface.Stub()
	{
		public void playFanfare()
		{
			mp.setDataSource(this, R.raw.fanfare);
			mp.prepare();
			mp.start();
		}
		
		public void stopFanfare()
		{
			mp.stop();
		}
	};
}

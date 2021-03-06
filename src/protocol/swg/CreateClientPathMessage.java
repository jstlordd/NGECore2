/*******************************************************************************
 * Copyright (c) 2013 <Project SWG>
 * 
 * This File is part of NGECore2.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Using NGEngine to work with NGECore2 is making a combined work based on NGEngine. 
 * Therefore all terms and conditions of the GNU Lesser General Public License cover the combination.
 ******************************************************************************/
package protocol.swg;

import java.nio.ByteOrder;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;

import engine.resources.common.CRC;
import engine.resources.common.StringUtilities;
import engine.resources.scene.Point3D;

public class CreateClientPathMessage extends SWGMessage {

	private List<Point3D> coordinates;
	
	public CreateClientPathMessage(List<Point3D> coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public void deserialize(IoBuffer data) {

	}

	@Override
	public IoBuffer serialize() {
		IoBuffer buffer = IoBuffer.allocate((coordinates.size() * 12) + 10).order(ByteOrder.LITTLE_ENDIAN);

		buffer.putShort((short) 2);
		buffer.putInt(CRC.StringtoCRC("CreateClientPathMessage"));
		
		buffer.putInt(coordinates.size());
		for(Point3D point : coordinates) {
			buffer.putFloat(point.x);
			buffer.putFloat(point.z);
			buffer.putFloat(point.y);
		}
		
		buffer.flip();
		StringUtilities.printBytes(buffer.array());
		return buffer;
	}

}

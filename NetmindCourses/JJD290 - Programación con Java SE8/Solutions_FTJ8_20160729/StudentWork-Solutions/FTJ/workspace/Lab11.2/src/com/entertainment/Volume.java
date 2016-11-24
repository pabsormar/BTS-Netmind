/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Interfaces
 * 
 * This interface defines the Volume role.
 *
 * Objects that implement this interface are known to
 * have "volume controllability," i.e., setVolume, getVolume, mute, isMuted.
 * 
 * Television (and thus its subclasses) implements this interface.
 * So does class Radio.
 * 
 * Note that, although Television and Radio have no 
 * inheritance relationship, they do play the same role, in 
 * that they are both "volume controllable."  Hence, a Television
 * and a Radio can both be treated as simply instances
 * of Volume, an interface type.
 */

package com.entertainment;

public interface Volume
{
   public void setVolume(int volume);
   public int getVolume();
   public void mute();
   public boolean isMuted();
}

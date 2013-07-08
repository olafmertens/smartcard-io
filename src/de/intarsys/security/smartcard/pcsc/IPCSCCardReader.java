/*
 * Copyright (c) 2013, intarsys consulting GmbH
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * - Neither the name of intarsys nor the names of its contributors may be used
 *   to endorse or promote products derived from this software without specific
 *   prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package de.intarsys.security.smartcard.pcsc;

/**
 * The abstraction of a card reader terminal in PCSC.
 * 
 * This is created by {@link IPCSCContext#listReaders()}.
 * 
 */
public interface IPCSCCardReader {

	public interface IStatusListener {
		public void onException(PCSCException e);

		public void onStatusChange(PCSCCardReaderState cardReaderState);
	}

	/**
	 * Add a listener for the card reader status changes.
	 * 
	 * @param listener
	 */
	public void addStatusListener(IStatusListener listener);

	/**
	 * The {@link IPCSCContext} that created this reader.
	 * 
	 * @return
	 */
	public IPCSCContext getContext();

	/**
	 * A unique id
	 * 
	 * @return
	 */
	public abstract int getId();

	/**
	 * The PSCS reader name.
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * Get the current {@link PCSCCardReaderState}.
	 * 
	 * @return
	 * @throws PCSCException
	 */
	public PCSCCardReaderState getState() throws PCSCException;

	/**
	 * Remove a previously registered listener for the card reader status
	 * changes.
	 * 
	 * @param listener
	 */
	public void removeStatusListener(IStatusListener listener);

}
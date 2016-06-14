# SendNFC
This project allows someone to send and receive files through NFC.
This will work only on NFC enabled devices. 

<b>How NFC Works</b>
<p>Like Bluetooth and WiFi, and all manner of other wireless signals, NFC works on the principle of sending information over radio waves. 
Through NFC data is send through electromagnetic induction between two devices.
NFC works on the bases of tags , it allows you to share some amount of data between an NFC tag and an android powered device or between two android powered devices. Tags have various set of complexities. The Data stored in the tag can be written in a variety of formats, but android APIs are based around a NFC standard called as NFC Data Exchange Format(NDEF)
The transmission frequency for data across NFC is 13.56 megahertz, and data can be sent at either 106, 212 or 424 kilobits per second, which is quick enough for a range of data transfers from contact details to swapping pictures, songs and videos. </p>

<b>Android powered devices with NFC supports following three main modes of operations - </b>

Three Modes of Operation
<ul>
<li><b>Reader/Writer Mode</b> </li>
It allows the NFC device to read or write passive NFC tags.

<li><b>P2P mode</b></li>
This mode allows NFC device to exchange data with other NFC peers.

<li><b>Card emulation mode</b></li>
It allows the NFC device itself to act as an NFC card, so it can be accessed by an external NFC reader.

# SpaceBattle

Videogioco 2D shoot ‘em up sviluppato in Java (IDE Eclipse. La libreria grafica integrata opensource LibGDX gestisce la fisica dei movimenti mediante il BOX2D physics engine ed il rendering è effettuato attraverso OpenGL ES. L’applicazione è articolata in 10 livelli di difficoltà crescente: l’utente gestisce una navicella spaziale, colpisce i nemici e avanza fino a una piattaforma per passare al livello successivo. Le sprite sheets sono state realizzate usando immagini non protette da copyright. Tutto il codice sorgente dell’applicazione è allegato ed opportunamente commentato. Sono presenti anche i Javadoc del progetto core, il cui package “it.insidecode.racogame.framework.level” contiene le classi principali della logica del progetto, referenziate dunque dai 2 progetti specifici per piattaforme desktop e mobile (android). Tali classi modellano il funzionamento del programma, rappresentando tipologie di nemici, ciascuno avente barra di vita, genere di sparo o colpo che infligge alla navicella dell’utente, movimento geometrico statico o dinamico (inseguendo la navicella). L’utente ha 2 modi per incrementare la barra di vita della navicella ed eventualmente trasformarla nella sua versione più performante: bonus per raggiungimento della piattaforma del livello successivo (solitamente un buco nero) oppure a seguito di un colpo inferto a una stella rossa che lascia cadere una moneta da ricevere. Tra un livello e l’altro viene temporaneamente renderizzato uno sfondo dinamico raffigurante il cielo nuvoloso e l’effetto sonoro del vento. Il livello finale prevede lo scontro con il nemico boss, caratterizzato da movimento intelligente e dinamico. Si allega anche il file in formato apk, che delega alla libreria Libgdx la gestione di default dell’interfaccia utente per mezzo del touch. Qualora si dovessero presentare problemi di compatibilità con tale file a causa di determinate caratteristiche di esportazione del progetto (versione di SDK, ambiente di sviluppo ma talvolta anche versione android e configurazioni del dispositivo su cui girerà il programma), è possibile comunque eseguire sul PC il file Jar con doppio click del mouse utilizzando i tasti direzionali per muoversi e lo spazio per sparare.

E' disponibile il file .jar eseguibile del gioco.

Di seguito si mostrano alcuni screenshot relativi all’esecuzione del gioco:

![1](https://user-images.githubusercontent.com/51203516/104854222-cc2ad600-5905-11eb-83ba-7780cec39e0f.jpg)
![2](https://user-images.githubusercontent.com/51203516/104854226-cf25c680-5905-11eb-9a41-67f93506a5cf.jpg)
![3](https://user-images.githubusercontent.com/51203516/104854235-d4831100-5905-11eb-8313-1dfe5c644117.jpg)
![4](https://user-images.githubusercontent.com/51203516/104854239-d6e56b00-5905-11eb-9b10-7f1fe6a1aefe.jpg)
![5](https://user-images.githubusercontent.com/51203516/104854244-dbaa1f00-5905-11eb-81e1-caac1ba6c99d.jpg)
![6](https://user-images.githubusercontent.com/51203516/104854245-dd73e280-5905-11eb-9e57-5a91f972ad43.jpg)
![7](https://user-images.githubusercontent.com/51203516/104854246-e369c380-5905-11eb-9d47-b3962d55b6e6.jpg)
![8](https://user-images.githubusercontent.com/51203516/104854248-e5cc1d80-5905-11eb-9818-c005092a000e.jpg)
![9](https://user-images.githubusercontent.com/51203516/104854249-e795e100-5905-11eb-80ef-b0b88f3785ab.jpg)
![10](https://user-images.githubusercontent.com/51203516/104854251-e95fa480-5905-11eb-8ff2-832096c6111c.jpg)

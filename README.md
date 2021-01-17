# SpaceBattle

Videogioco 2D shoot ‘em up sviluppato in Java (IDE Eclipse. La libreria grafica integrata opensource LibGDX gestisce la fisica dei movimenti mediante il BOX2D physics engine ed il rendering è effettuato attraverso OpenGL ES. L’applicazione è articolata in 10 livelli di difficoltà crescente: l’utente gestisce una navicella spaziale, colpisce i nemici e avanza fino a una piattaforma per passare al livello successivo. Le sprite sheets sono state realizzate usando immagini non protette da copyright. Tutto il codice sorgente dell’applicazione è allegato ed opportunamente commentato. Sono presenti anche i Javadoc del progetto core, il cui package “it.insidecode.racogame.framework.level” contiene le classi principali della logica del progetto, referenziate dunque dai 2 progetti specifici per piattaforme desktop e mobile (android). Tali classi modellano il funzionamento del programma, rappresentando tipologie di nemici, ciascuno avente barra di vita, genere di sparo o colpo che infligge alla navicella dell’utente, movimento geometrico statico o dinamico (inseguendo la navicella). L’utente ha 2 modi per incrementare la barra di vita della navicella ed eventualmente trasformarla nella sua versione più performante: bonus per raggiungimento della piattaforma del livello successivo (solitamente un buco nero) oppure a seguito di un colpo inferto a una stella rossa che lascia cadere una moneta da ricevere. Tra un livello e l’altro viene temporaneamente renderizzato uno sfondo dinamico raffigurante il cielo nuvoloso e l’effetto sonoro del vento. Il livello finale prevede lo scontro con il nemico boss, caratterizzato da movimento intelligente e dinamico. Si allega anche il file in formato apk, che delega alla libreria Libgdx la gestione di default dell’interfaccia utente per mezzo del touch. Qualora si dovessero presentare problemi di compatibilità con tale file a causa di determinate caratteristiche di esportazione del progetto (versione di SDK, ambiente di sviluppo ma talvolta anche versione android e configurazioni del dispositivo su cui girerà il programma), è possibile comunque eseguire sul PC il file Jar con doppio click del mouse utilizzando i tasti direzionali per muoversi e lo spazio per sparare.

Di seguito si mostrano alcuni screenshot relativi all’esecuzione del gioco:

E' disponibile il file .jar eseguibile del gioco.

![sp1](https://user-images.githubusercontent.com/51203516/70462124-82dd4580-1aba-11ea-8bbb-1c1ac99721ac.jpg)

![sp2](https://user-images.githubusercontent.com/51203516/70462145-8c66ad80-1aba-11ea-896c-e165122b5fb5.jpg)

![sp3](https://user-images.githubusercontent.com/51203516/70462155-938dbb80-1aba-11ea-8168-da30b093d984.jpg)

![sp4](https://user-images.githubusercontent.com/51203516/70462164-9a1c3300-1aba-11ea-8c1d-be01a5ece85d.jpg)

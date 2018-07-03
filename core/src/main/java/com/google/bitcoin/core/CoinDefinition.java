package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: CannabisCoin
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "CannabisCoin";
    public static final String coinTicker = "CANN";
    public static final String coinURIScheme = "CannabisCoin";
    public static final String cryptsyMarketId = "300";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "6";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://chainz.cryptoid.info/cann/";    //CANN
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address.dws?";             //CANN
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx.dws?";              //CANN
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block.dws?";                 //CANN
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "CVZiDB3qBR9hSEm9C95dfKVeSGGyh3E1Cn";  //CannabisCoin donation address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 6 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(42);  // 10 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 30; //main.h: static const int COINBASE_MATURITY
    public static int spendableCoinbaseDepthForkOne = 100;
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(420000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "420000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(100000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70017;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70010;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 39348;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 29347;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 28;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0xfec3b9de;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1400408750L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (325433);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000a10f7ce671e773330376ce892a6c0b93fbc05553ebbf659b11e3bf9188d"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 420;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisXInBytes = "04ffff001d010403343230";
    static public String genessiXOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "seed.cannabiscoin.net",
            "seed2.cannabiscoin.net",
            "seed3.cannabiscoin.net",
            "seed4.cannabiscoin.net",
            "seed5.cannabiscoin.net",
            "seed6.cannabiscoin.net"
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - CannabisCoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1397088621L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (97207);                         //main.cpp: LoadBlockIndex

    public static int subsidyDecreaseBlockCount = 100000;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "041af8de5ad3726c66a24be8ff8e662b8f564b8d354358356f45e2ceb654502dfcce106cc9b2eccdc91925469d4c429ad2df41670fbf20273594565dc9f896ee77";
    public static final String TESTNET_SATOSHI_KEY = "041497c60c0e082615c0c43509e278b3716bf46b7adc17847a5d604db89d2c7be56fc625130c49b64a104d870267ec9f8cae5702a0040af4aa9a4e3833b26573c9";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.cannabiscoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.cannabiscoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.cannabiscoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0,   new Sha256Hash("00000a10f7ce671e773330376ce892a6c0b93fbc05553ebbf659b11e3bf9188d"));
        checkpoints.put( 57600, new Sha256Hash("0000000015fedc25afc3db164ef667cc7b86761e430ad2c8348178b35f3a7ae5"));
        checkpoints.put( 115200, new Sha256Hash("000000000d48cdef252c47317ff3ec976e6690d8fa16e736162f5660c210cb88"));
        checkpoints.put( 172800, new Sha256Hash("000000000029b8da63ad224f0af1d6ae1dda36df76685584cff7b8291425fff9"));
        checkpoints.put( 230400, new Sha256Hash("000000000197256fb0a4439f97c158781e4a0c6bbc50943789b6454f30d03737"));
        checkpoints.put( 288000, new Sha256Hash("00000000000689e15ee64d18d17bde40a55c9c739d2104487620d9c94fde49a6"));
        checkpoints.put( 345600, new Sha256Hash("000000000247734e6bf547ba4bfc0948df0854a8ec2a7e07a6424f9a2867847a"));
        checkpoints.put( 403200, new Sha256Hash("0000000004175725c085588b751f1680d02be94e3b620049e0653c1b99a2ad22"));
        checkpoints.put( 460800, new Sha256Hash("0000000003d7ffd06b7caa52abfb2b61857fc20023802d3f20c7bfa268e9f0c0"));
        checkpoints.put( 518400, new Sha256Hash("00000000050ee93ba705ebb3ebb0b0290d84fcbadc35b2ddfeeb9e2fc45fa9c6"));
        checkpoints.put( 576000, new Sha256Hash("000000000513e8d692fc15b90dc217ea6a2ecfb87f8f6008621043c42f11be18"));
        checkpoints.put( 633600, new Sha256Hash("000000000547c4c5b882b98bd472fef0417d1f66bab9a38e0b55310420aee65b"));
        checkpoints.put( 691200, new Sha256Hash("000000000fe9f5cafc96a1f3217033b4f37a52d1465c16bf866eac6cb6460950"));
        checkpoints.put( 748800, new Sha256Hash("0000000028f231274ddafdb2127f1e944685fd4a010a0990605616953690401a"));
        checkpoints.put( 806400, new Sha256Hash("000000000607e68c5758df6595f318e70ab1d0f5c6620a11a47873d7fe080686"));
        checkpoints.put( 864000, new Sha256Hash("0000000019689b58de02a327a7454ec7faa5cafc71f837bf0b1903386483a3a5"));
        checkpoints.put( 921600, new Sha256Hash("00000000456f8a90b5dbbe6b9ba95cf79262cfb51db87b1de517996bf7a9421c"));
        checkpoints.put( 979200, new Sha256Hash("000000006860a93401d32538d1454962b6f64834f005d9b3027e770b49a39bbc"));
        checkpoints.put( 1036800, new Sha256Hash("00000000a9a5fa171cc3cd81b46e8773d845153310e1a51c63e821537e751395"));
        checkpoints.put( 1094400, new Sha256Hash("000000002fac5cfff0c6efb1641662547c0d9046f455236beb8f094a4599dbee"));
        checkpoints.put( 1121000, new Sha256Hash("000000012b18631c9d5d90e3c5a32655f63ae1100ff8cafbde184521deba0960"));
        checkpoints.put( 1135050, new Sha256Hash("000000014d3dfb1e1a6cfa86d00baf64acd273da8536badc9aaf4f090a9b77af"));
        checkpoints.put( 1500000, new Sha256Hash("0000000139e964504c583e50d683945835e363e45d23105af5329907971874d2"));
        checkpoints.put( 2000000, new Sha256Hash("0000000b7ce8df7d29d04f0c8c44efd44b43a944ebaf1a564ef774914cd577bb"));
        checkpoints.put( 2500000, new Sha256Hash("0000000000003cbb0b1acd5df4de9b8eae0a19fbf8d5c65844b4a5ce933fe3bf"));
        checkpoints.put( 3000000, new Sha256Hash("000000000000082040eec901ac550587fb518d28e591df8593e766b9005d8fca"));

    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";

}
